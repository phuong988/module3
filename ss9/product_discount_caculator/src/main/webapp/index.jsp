<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title>Product Discount Calculator</title>
</head>
<body>
<h2>Product Discount Calculator</h2>
<form action="display-discount" method="post">
    <label>Product Description:</label>
    <input type="text" name="description" required/><br/><br/>

    <label>List Price:</label>
    <input type="number" name="listPrice" step="0.01" required/><br/><br/>

    <label>Discount Percent (%):</label>
    <input type="number" name="discountPercent" step="0.01" required/><br/><br/>

    <input type="submit" value="Calculate Discount"/>
</form>
</body>
</html>