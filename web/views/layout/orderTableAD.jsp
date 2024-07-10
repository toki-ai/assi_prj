<tr>
    <td style="padding: 2px 5px ">${o.orderID}</td>
    <td style="padding: 2px 5px ">${o.customerID}</td>
    <td style="padding: 2px 5px ">${o.orderDate}</td>
    <td style="padding: 2px 5px ">${o.requiredDate}</td>
    <td style="padding: 2px 5px ">${o.shippedDate}</td>
    <td style="padding: 2px 5px ">${o.freight}</td>
    <td style="padding: 2px 5px ">${o.shipAddress}</td>
    <td style="padding: 2px 10px ">
        <a href="ordersAD?oid=${o.orderID}&cid=${o.customerID}" style="margin-right: 10px">
            <i style="color: #3eccec" class="fa-solid fa-eye"></i>
        </a> 
        <a href="delete?option=order&oid=${o.orderID}" onclick="return confirmDelete()">
            <i style="color: #f38216" class="fa-solid fa-trash"></i>
        </a>                                 
    </td>
</tr>
