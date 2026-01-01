import tensorflow as tf
from tensorflow import keras
import matplotlib.pyplot as plt

# 1. Load and Preprocess the MNIST dataset
(x_train, y_train), (x_test, y_test) = keras.datasets.mnist.load_data()

# Normalize pixel values to [0, 1]
x_train = x_train / 255.0
x_test = x_test / 255.0

# Flatten the 28x28 images into 784-dimensional vectors
x_train_flat = x_train.reshape(-1, 28*28)
x_test_flat = x_test.reshape(-1, 28*28)

# 2. Define and Train the Feedforward Neural Network with different activations
def build_and_train_model(activation_function):
    model = keras.Sequential([
        keras.layers.Dense(128, activation=activation_function, input_shape=(784,)),
        keras.layers.Dense(64, activation=activation_function),
        keras.layers.Dense(10, activation='softmax') # Output layer for 10 classes
    ])

    model.compile(optimizer='adam',
                  loss='sparse_categorical_crossentropy',
                  metrics=['accuracy'])

    history = model.fit(x_train_flat, y_train, epochs=10, validation_split=0.2, verbose=0)
    _, accuracy = model.evaluate(x_test_flat, y_test, verbose=0)
    print(f"Activation: {activation_function}, Test Accuracy: {accuracy:.4f}")
    return history

# Train with different activation functions
print("Training with ReLU:")
history_relu = build_and_train_model('relu')

print("\nTraining with Sigmoid:")
history_sigmoid = build_and_train_model('sigmoid')

print("\nTraining with Tanh:")
history_tanh = build_and_train_model('tanh')

# 3. Analyze the Influence of Activation Functions (Optional: Plotting)
plt.figure(figsize=(12, 5))

plt.subplot(1, 2, 1)
plt.plot(history_relu.history['accuracy'], label='ReLU Train Accuracy')
plt.plot(history_relu.history['val_accuracy'], label='ReLU Val Accuracy')
plt.plot(history_sigmoid.history['accuracy'], label='Sigmoid Train Accuracy')
plt.plot(history_sigmoid.history['val_accuracy'], label='Sigmoid Val Accuracy')
plt.plot(history_tanh.history['accuracy'], label='Tanh Train Accuracy')
plt.plot(history_tanh.history['val_accuracy'], label='Tanh Val Accuracy')
plt.title('Model Accuracy vs. Epochs')
plt.xlabel('Epoch')
plt.ylabel('Accuracy')
plt.legend()

plt.subplot(1, 2, 2)
plt.plot(history_relu.history['loss'], label='ReLU Train Loss')
plt.plot(history_relu.history['val_loss'], label='ReLU Val Loss')
plt.plot(history_sigmoid.history['loss'], label='Sigmoid Train Loss')
plt.plot(history_sigmoid.history['val_loss'], label='Sigmoid Val Loss')
plt.plot(history_tanh.history['loss'], label='Tanh Train Loss')
plt.plot(history_tanh.history['val_loss'], label='Tanh Val Loss')
plt.title('Model Loss vs. Epochs')
plt.xlabel('Epoch')
plt.ylabel('Loss')
plt.legend()

plt.tight_layout()
plt.show()