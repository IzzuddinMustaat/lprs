import cv2
import easyocr
# 🔗 This line imports your database script function directly!
from saveSql import record_plate  

# 1. Get image path
image_path = input("Enter image filename (e.g. car1.jpeg): ")

# 2. Read image
img = cv2.imread(image_path)

if img is None:
    print("Error: Image not found! Double-check the filename and extension.")
    exit()

print("Processing image...")

# 3. Optimize image for OCR (Helps with low-light parking areas)
# Convert to grayscale
gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
# Boost contrast so white text on black plate stands out sharper
processed_img = cv2.threshold(gray, 0, 255, cv2.THRESH_BINARY + cv2.THRESH_OTSU)[1]

# 4. Initialize EasyOCR
reader = easyocr.Reader(['en'], gpu=False) # Explicitly tells it to use CPU smoothly

print("Scanning for text...")
results = reader.readtext(processed_img)

# 5. Filter, print, and transmit results
print("\n=== SCAN RESULTS ===")
found_any = False

for result in results:
    text = result[1].replace(" ", "").upper()
    confidence = result[2]

    # Look for strings matching Malaysian plate styles (Letters + Numbers)
    if len(text) >= 3 and confidence > 0.3:
        print(f"Detected: {text} (Confidence: {confidence*100:.1f}%)")
        found_any = True
        
        # ==========================================================
        # 🔗 TRANSMIT TO DATABASE SCRIPT
        # ==========================================================
        print(f"Sending {text} to the database handler...")
        
        # Calls the function inside saveSql.py instantly
        record_plate(text)
        
        # Break the loop so it only logs the plate once per image scan
        break

if not found_any:
    print("No clear text detected. Try a clearer image or closer angle!")