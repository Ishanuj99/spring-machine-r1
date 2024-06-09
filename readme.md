Deal {
 dealId: String,
 startTime: timestamp,
 expiryTime: timestamp (initially be null),
 isActive: String
 productInventory : [productInventory1 , productInventory2]
}

productInventory {
 id: String UUID,
 price: Double,
 stock: Integer
}

Purchase {
 purhaseId: String,
 purchaseTimestamp: timestamp,
 dealId: String,
 userId: String
}