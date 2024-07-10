<tr>
    <td style="padding: 2px 5px ">${o.orderID}</td>
    <td style="padding: 2px 5px ">${o.customerID}</td>
    <td style="padding: 2px 5px ">${o.orderDate}</td>
    <td style="padding: 2px 5px ">${o.requiredDate}</td>
    <td style="padding: 2px 5px ">${o.shippedDate}</td>
    <td style="padding: 2px 5px ">${o.freight}</td>
    <td style="padding: 2px 5px ">${o.shipAddress}</td>
    <td style="padding: 2px 5px ">
        <a href="detail?id=${p.productID}">
            <i style="color: gray" class="fa-solid fa-eye"></i>
        </a> 
        <a style="margin: 0 30px" href="detail?id=${p.productID}">
            <i class="fa-solid fa-pen-to-square"></i>
        </a> 
        <a href="detail?id=${p.productID}">
            <i style="color: red" class="fa-solid fa-trash"></i>
        </a>                                 
    </td>
</tr>
