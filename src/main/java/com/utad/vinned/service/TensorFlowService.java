package com.utad.vinned.service;

import org.springframework.stereotype.Service;
import org.tensorflow.*;

@Service
public class TensorFlowService {

    private static final String MODEL_PATH = "src/main/resources/tensorflow/harvest_model";
    private final SavedModelBundle model;

    public TensorFlowService() {
        // Cargar el modelo usando el tag "serve"
        this.model = SavedModelBundle.load(MODEL_PATH, "serve");
    }

    public float predictHarvest(float sizeHectares, int grapeVariety) {
        try (Session session = model.session();
             Tensor<Float> inputTensor = Tensor.create(new float[][]{{sizeHectares / 5.0f, grapeVariety / 3.0f}}, Float.class)) {

            try (Tensor<?> output = session.runner()
                    .feed("serving_default_input_layer", inputTensor) // <- Nombre correcto de la capa de entrada
                    .fetch("StatefulPartitionedCall") // <- Si esto falla, usa "serving_default_output_layer"
                    .run()
                    .get(0)) {

                float[][] prediction = new float[1][1];
                output.copyTo(prediction);
                return prediction[0][0] * 400.0f; // Escalar a valores reales
            }
        } catch (Exception e) {
            throw new RuntimeException("Error en la predicción con TensorFlow", e);
        }
    }
}
