# Delivery-System
Package delivery system, handles the shipping of parcels from a base warehouse to the receiver's address.
All users (except the Admin) must be added manually by the Admin, except new "Receivers" of parcels, they can sign up by themselves.
Warehouses (except the base warehouse), vehicles, parcels, items - are all added manually by the Admin.
After all of the elements are added, the system can properly function.

Main process:
1. [START] Admin adds a new parcel and affiliates it with a Receiver.
2. A coordinator plans a delivery route for any truck. The route should end up at the warehouse in the Reciever's city.
3. A truck driver loads the parcels from the base warehouse and drives to the next warehouse in the coordinator's plan.
4. After reaching the final warehouse, a Car driver delivers the parcels to the Receiver's address. [END]
