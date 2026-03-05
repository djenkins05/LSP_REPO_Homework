# ATC System — CRC Cards (Assignment 4)

---

## CRC Card
**Class:** Aircraft  

**Responsibilities:**
- Maintain aircraft type and identifying information
- Provide current flight state to onboard transmitter  

**Collaborators:**
- Transponder  

**Assumptions:**
- Each aircraft has exactly one transponder installed

---

## CRC Card
**Class:** Transponder  

**Responsibilities:**
- Collect aircraft type and flight state from Aircraft
- Package flight data into high-density packets
- Broadcast packets to the ATC ground system  

**Collaborators:**
- Aircraft
- ATC_GroundStation  

**Assumptions:**
- Broadcast occurs periodically while aircraft is in range

---

## CRC Card
**Class:** ATC_GroundStation

**Responsibilities:**
- Receive transponder packets
- Unpack packets into structured flight data
- Send unpacked flight data to AircraftDatabase  

**Collaborators:**
- AircraftDatabase  

**Assumptions:**
- Packet format is known and consistent
- Ground station does not analyze or display data directly

---

## CRC Card
**Class:** AircraftDatabase  

**Responsibilities:**
- Store aircraft flight data records
- Update aircraft records when new data arrives
- Retrieve aircraft records by aircraft identifier  

**Collaborators:**
- None  

**Assumptions:**
- Records are keyed by a unique aircraft identifier (e.g., transponder code)

---

## CRC Card
**Class:** DisplayScheduler  

**Responsibilities:**
- Trigger display refresh every 10 seconds
- Request the latest display snapshot from DisplaySystem  

**Collaborators:**
- DisplaySystem  

**Assumptions:**
- System clock is available and reliable

---

## CRC Card
**Class:** DisplaySystem  

**Responsibilities:**
- Build a screen-ready view from AircraftDatabase records
- Render aircraft positions and labels for the controller
- Support selection of an on-screen aircraft  

**Collaborators:**
- AircraftDatabase
- ControllerQueryService  

**Assumptions:**
- Rendering details are abstracted (Implementation not required)

---

## CRC Card
**Class:** ConflictDetector  

**Responsibilities:**
- Analyze aircraft data to detect dangerous situations
- Create alerts when danger conditions are found
- Clear alerts when conditions are no longer dangerous  

**Collaborators:**
- AircraftDatabase
- AlertService  

**Assumptions:**
- “Dangerous” is defined by rule thresholds (e.g., separation limits)

---

## CRC Card
**Class:** AlertService  

**Responsibilities:**
- Store and manage active alerts
- Provide alert status to the controller-facing UI
- Notify controller-facing components of new/cleared alerts  

**Collaborators:**
- ConflictDetector
- ControllerConsole  

**Assumptions:**
- Alerts are keyed by aircraft id (or pair of aircraft ids)

---

## CRC Card
**Class:** ControllerQueryService  

**Responsibilities:**
- Handle controller requests for aircraft details
- Retrieve aircraft records from AircraftDatabase
- Return formatted aircraft details to the controller UI  

**Collaborators:**
- AircraftDatabase
- ControllerConsole  

**Assumptions:**
- UI passes a valid aircraft identifier when querying

---

## CRC Card
**Class:** ControllerConsole  

**Responsibilities:**
- Display the graphics view to the controller
- Display alerts and alert status
- Accept controller input (select aircraft, request details) 
 
**Collaborators:**
- DisplaySystem
- ControllerQueryService
- AlertService
  
**Assumptions:**
- Controller interacts only through this UI boundary

---

## AI / Internet Usage Note
The following external resource was consulted for general background understanding of how modern air traffic control systems operate:

HowStuffWorks. “How Air Traffic Control Works.”  
https://science.howstuffworks.com/transport/flight/modern/air-traffic-control.htm


