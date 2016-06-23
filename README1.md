Overview
========

HTTP verbs
----------

RESTful notes tries to adhere as closely as possible to standard HTTP and REST conventions in its use of HTTP verbs.

<table>
<colgroup>
<col width="50%" />
<col width="50%" />
</colgroup>
<thead>
<tr class="header">
<th>Verb</th>
<th>Usage</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><p><code>GET</code></p></td>
<td><p>Used to retrieve a resource</p></td>
</tr>
<tr class="even">
<td><p><code>POST</code></p></td>
<td><p>Used to create a new resource</p></td>
</tr>
<tr class="odd">
<td><p><code>PATCH</code></p></td>
<td><p>Used to update an existing resource, including partial updates</p></td>
</tr>
<tr class="even">
<td><p><code>DELETE</code></p></td>
<td><p>Used to delete an existing resource</p></td>
</tr>
</tbody>
</table>

HTTP status codes
-----------------

RESTful notes tries to adhere as closely as possible to standard HTTP and REST conventions in its use of HTTP status codes.

<table>
<colgroup>
<col width="50%" />
<col width="50%" />
</colgroup>
<thead>
<tr class="header">
<th>Status code</th>
<th>Usage</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><p><code>200 OK</code></p></td>
<td><p>The request completed successfully</p></td>
</tr>
<tr class="even">
<td><p><code>201 Created</code></p></td>
<td><p>A new resource has been created successfully. The resource’s URI is available from the response’s <code>Location</code> header</p></td>
</tr>
<tr class="odd">
<td><p><code>204 No Content</code></p></td>
<td></td>
</tr>
</tbody>
</table>