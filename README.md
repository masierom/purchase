# Project component: purchase (shop-purchase)
Component of Cloud Project (UfPrCloud2);

Composed of:
- catalog (shop-catalog)
- purchase (shop-purchase)
- shop-rating
- shop-recommender
- registry
- gateway

## Mini API docs
**Get purchase list by userId**
```
GET /api/purchase/{userId}
```
- Path Parameters: userId
- **Return** an array of Purchase (JSON object)

**Get a single purchase by userId, purchaseId**
```
GET /api/purchase/{userId}/{purchaseId}
```
- Path Parameters: userId, purchaseId
- **Return** Purchase (JSON object)

**Insert purchase (buy)**
```
POST /api/purchase/{userId}
```
- Path Parameters: userId
- Body Parameters: productId, quantity
- **Return** Purchase (JSON object)

**Get user list by productId**
```
GET /api/purchase/users/{productId}
```
- Path Parameters: productId
- **Return** an array of User (JSON object)
  - *User*: composed of userId
