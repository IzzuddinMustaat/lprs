import mysql.connector




# This function receives the plate number directly from detectPlate.py
def record_plate(plate_number):
    
    if not plate_number:
        print("No plate number received!")
        return

    # ==========================================
    # CONNECT TO MYSQL
    # ==========================================
    db = mysql.connector.connect(
        host="localhost",
        user="root",
        password="",
        database="lprs"
    )

    cursor = db.cursor()

    # ==========================================
    # CHECK ENTRY OR EXIT
    # ==========================================
    sql_check = (
        "SELECT id "
        "FROM vehicle_log "
        "WHERE plateNum = %s AND exit_time IS NULL"
    )
    cursor.execute(sql_check, (plate_number,))
    existing = cursor.fetchone()

    if existing:
        # Already inside → record exit
        sql = (
            "UPDATE vehicle_log "
            "SET exit_time = NOW() "
            "WHERE id = %s"
        )
        cursor.execute(sql, (existing[0],))
        db.commit()
        print(f"✅ Exit recorded for: {plate_number}")

    else:
        # New plate → record entry
        sql = (
            "INSERT INTO vehicle_log "
            "(plateNum, entry_time) "
            "VALUES (%s, NOW())"
        )
        cursor.execute(sql, (plate_number,))
        db.commit()
        print(f"✅ Entry recorded for: {plate_number}")

    cursor.close()
    db.close()


#user input the plate number
while True:
    plate_number = input("Enter plate number to record (0 to exit): ").strip().upper()

    if plate_number == "0":
        print("Exiting program...")
        break

    if plate_number:
        record_plate(plate_number)
    else:
        print("Empty input, please try again.")