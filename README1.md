Overview
========

HTTP verbs {#overview-http-verbs}
----------

RESTful notes tries to adhere as closely as possible to standard HTTP
and REST conventions in its use of HTTP verbs.

+--------------------------------------+--------------------------------------+
| Verb                                 | Usage                                |
+======================================+======================================+
| `GET`                                | Used to retrieve a resource          |
+--------------------------------------+--------------------------------------+
| `POST`                               | Used to create a new resource        |
+--------------------------------------+--------------------------------------+
| `PATCH`                              | Used to update an existing resource, |
|                                      | including partial updates            |
+--------------------------------------+--------------------------------------+
| `DELETE`                             | Used to delete an existing resource  |
+--------------------------------------+--------------------------------------+

HTTP status codes {#overview-http-status-codes}
-----------------

RESTful notes tries to adhere as closely as possible to standard HTTP
and REST conventions in its use of HTTP status codes.

+--------------------------------------+--------------------------------------+
| Status code                          | Usage                                |
+======================================+======================================+
| `200 OK`                             | The request completed successfully   |
+--------------------------------------+--------------------------------------+
| `201 Created`                        | A new resource has been created      |
|                                      | successfully. The resource’s URI is  |
|                                      | available from the response’s        |
|                                      | `Location` header                    |
+--------------------------------------+--------------------------------------+
| `204 No Content`                     | An update to an existing resource    |
|                                      | has been applied successfully        |
+--------------------------------------+--------------------------------------+
| `400 Bad Request`                    | The request was malformed. The       |
|                                      | response body will include an error  |
|                                      | providing further information        |
+--------------------------------------+--------------------------------------+
| `404 Not Found`                      | The requested resource did not exist |
+--------------------------------------+--------------------------------------+

Errors {#overview-errors}
------

Whenever an error response (status code &gt;= 400) is returned, the body
will contain a JSON object that describes the problem. The error object
has the following structure:

Unresolved directive in api-guide.adoc -
include::E:\\Java\\Project\\restaurantvote\\target/generated-snippets/error-example/response-fields.adoc\[\]

For example, a request that attempts to apply a non-existent tag to a
note will produce a `400 Bad Request` response:

Unresolved directive in api-guide.adoc -
include::E:\\Java\\Project\\restaurantvote\\target/generated-snippets/error-example/http-response.adoc\[\]

Hypermedia {#overview-hypermedia}
----------

RESTful Notes uses hypermedia and resources include links to other
resources in their responses. Responses are in [Hypertext Application
from resource to resource. Language
(HAL)](http://stateless.co/hal_specification.html) format. Links can be
found beneath the `_links` key. Users of the API should not create URIs
themselves, instead they should use the above-described links to
navigate

Resources
=========

Restaurants {#resources-notes}
-----------

The Notes resources is used to create and list notes

### Creating a restaurant {#test-create-with-location}

A `POST` request is used to cratee a restaurant

#### Request structure {#_request_structure}

+-------------------------+-------------------------+-------------------------+
| Path                    | Type                    | Description             |
+=========================+=========================+=========================+
| name                    | String                  | Name of the restaurant  |
+-------------------------+-------------------------+-------------------------+

#### Example request {#_example_request}

``` {.bash}
$ curl 'http://localhost:8080/rest/admin/restaurants/' -i -X POST -H 'Content-Type: application/json;charset=UTF-8' -d '{
  "name" : "Шотиииииии"
}'
```

#### Example response {#_example_response}

``` {.http}
HTTP/1.1 201 Created
Location: http://localhost:8080/rest/admin/restaurants/100029
Content-Type: application/json;charset=UTF-8
Content-Length: 57

{
  "id" : 100029,
  "name" : "Шотиииииии"
}
```
