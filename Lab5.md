# Lab 5. Implementing and Optimizing Database Queries

## 1. SQL Query Optimization

<br/>

#### 1.1 Orders Query: Retrieve orders with many items and calculate the total price.

Original query

    SELECT Orders.OrderID, SUM(OrderDetails.Quantity * OrderDetails.UnitPrice) AS TotalPrice
    FROM Orders
    JOIN OrderDetails ON Orders.OrderID = OrderDetails.OrderID
    WHERE OrderDetails.Quantity > 10
    GROUP BY Orders.OrderID;

<u>Inefficiencies </u>
* It is not consider pagination
* Could be not considering indexes 
* Could be not considering cache if that is a frequent query
* It is not validating if some field in SUM operation could be null


<u>Modifications to optimize these queries</u>
* Create index for OrderID field in OrderDetails table and Orders table
* Create index for Quantity field in OrderDetails table
* Create index for UnitPrice field in OrderDetails table
* If this query is frequent, implement Redis cache or cache from Motor database
* We Could use Pagination for the Query whether the result will be used for mobile/web app
* We could consider add in WHERE section, add fields will be  != null to limit results  
* We could consider only orders from the current year. Maybe using filter in WHERE or also using Horizontal partitioning to only access to table that contains orders of the current year 

<u>Theoretical application </u>

    CREATE INDEX OrderIDIndex ON Customers (OrderID);
    CREATE INDEX OrderIDIndex ON OrderDetails (OrderID);
    CREATE INDEX QuantityIndex ON OrderDetails (Quantity);
    CREATE INDEX UnitPriceIndex ON OrderDetails (UnitPrice);
    
    SELECT Orders.OrderID, SUM(OrderDetails.Quantity * OrderDetails.UnitPrice) AS TotalPrice
    FROM Orders
    JOIN OrderDetails ON Orders.OrderID = OrderDetails.OrderID
    WHERE OrderDetails.Quantity > 10
    GROUP BY Orders.OrderID;
    LIMIT 0,10 # first value indicate the offset, and it will increment in each next page`

We could do horizontal partition for ORDERS table in the new Orders2024 to only access to orders in the current year
Or Using sharding to have replicas from database, and a middleware or balancer redirect query to specific instance

if the query retrieve orders from the past that are not changing, could be use redis cache

    FUNC retrieve_resume_orders()
        key = concat(result_report_ , year )

        IF redis.get(key) is null

            QUERY results = results(year)
            CACHING
                key = concat(result_report_ , year )
                redis.put( key,  results, ttl)

        ELSE
            
            RETURN redis.get(key)


<br/>


#### 1.2 Customer Query: Find all customers from London and sort by CustomerName.

Original query

    SELECT CustomerName FROM Customers WHERE City = 'London' 
    ORDER BY CustomerName;

<u>Inefficiencies </u>
* If the table contains a lot of data, could late in search information
* If the columns involved in query does not have indexes, the performance will be low

<u>Modifications to optimize these queries</u>
* Create index for CustomerName field
* Create index for City field
* We Could use Pagination for the Query whether the result will be used for mobile/web app 

<u>Theoretical application/solution </u>

    CREATE INDEX CustomerNameIndex ON Customers (CustomerName);
    CREATE INDEX CityIndex ON Customers (City);

    SELECT CustomerName FROM Customers 
    WHERE City = 'London'
    ORDER BY CustomerName
    LIMIT 0,10 # first value indicate the offset, and it will increment in each next page`

<br/>

## 2. NoSQL Query Implementation

<br/>

#### 2.1 User Posts Query: Retrieve the most popular active posts and display their title and like count.

Original query

    db.posts
    .find({ status: "active" }, { title: 1, likes: 1 })
    .sort({ likes: -1 });

<u>Changes to improve query performance</u>
* Create a compound index using precedence `ESR strategy` (equality, Sort, Range)
* Could use cache whether the query is frequent 
 

<u>Suggestions about the document schema, indexes, or optimizing aggregation pipelines</u>

    db.posts.createIndex({ "active" : 1 , "title" : 1 , likes: -1 });
    
    we could use a mongo cluster setup, because it has already this feature, and allow high availability and dynamic scalability


#### 2.2 User Data Aggregation: Summarize the number of active users by location.

Original query

    db.users.aggregate([
    { $match: { status: "active" } },
    { $group: { _id: "$location", totalUsers: { $sum: 1 } } },
    ]);

<u>Changes to improve query performance</u>

* Could create index for `status` field
* Could create index for `location` field

<u>Suggestions about the document schema, indexes, or optimizing aggregation pipelines</u>

    db.users.createIndex({ "status" : 1 , "location" : 1 });

    we could use a mongo cluster setup, because it has already this feature, and allow high availability and dynamic scalability

