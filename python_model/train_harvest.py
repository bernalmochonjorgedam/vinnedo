import tensorflow as tf
import numpy as np
import os
import pandas as pd

data = {
    "plot_size": [1.2, 3.5, 2.0, 4.1, 3.0, 2.8, 3.7, 4.5, 5.0, 2.3],
    "grape_variety": [1, 2, 1, 3, 2, 1, 3, 2, 3, 1],
    "quantityKg": [100, 250, 150, 300, 200, 180, 270, 350, 400, 170]
}

df = pd.DataFrame(data)

x_train = df[["plot_size", "grape_variety"]].values / np.max(df[["plot_size", "grape_variety"]].values, axis=0)
y_train = df["quantityKg"].values.reshape(-1, 1) / np.max(df["quantityKg"].values)

# 🔹 Creación del modelo
model = tf.keras.Sequential([
    tf.keras.layers.Input(shape=[2], name="input_layer"),
    tf.keras.layers.Dense(16, activation="relu"),
    tf.keras.layers.Dense(16, activation="relu"),
    tf.keras.layers.Dense(1, name="output_layer")
])

model.compile(optimizer="adam", loss="mse")
model.fit(x_train, y_train, epochs=300, verbose=0)

# 🔹 Guardar el modelo en el formato correcto
MODEL_DIR = "harvest_model"
if not os.path.exists(MODEL_DIR):
    os.makedirs(MODEL_DIR)

tf.saved_model.save(model, MODEL_DIR)

print(f"✅ Modelo de `Harvest` guardado en {MODEL_DIR}/")
