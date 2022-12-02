# Connection Group

### Enhancements:

* For the get by Virtual Node API, it performs a sequential scan on all nodes of all the connection groups. This can be optimized by having a map of Node name to connection group, but that would mean we would not have a single source of truth for data, and it is our job while adding new connection groups that we keep both data structures consistent.
* Using an in-memory data structure to store the data, which gets wiped out on server restart. For persistence, we can think of an external database that would be suitable for such hierarchical data.

### Developer

* Anuj Hydrabadi (anujhydrabadi@gmail.com)