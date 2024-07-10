<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f8f9fa;
    }
    .container1 {        
        margin: 20px;
        max-width: 1200px;
        margin: 0 auto;
        padding: 20px;
        background-color: #ffffff;
        border-radius: 8px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }
    .header {
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-bottom: 20px;
    }
    .header input[type="text"] {
        padding: 10px;
        border: 1px solid #dee2e6;
        border-radius: 4px;
        width: 300px;
    }
    .header input[type="text"]::placeholder {
        color: #adb5bd;
    }
    .header .date-picker {
        padding: 10px;
        border: 1px solid #dee2e6;
        border-radius: 4px;
        margin-right: 20px;
    }
    .header .export-button {
        padding: 10px 20px;
        background-color: #6f42c1;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    .table-responsive {
        overflow-x: auto;
    }
    table {
        width: 100%;
        border-collapse: collapse;
    }
    table thead th {
        background-color: #f1f3f5;
        padding: 12px;
        text-align: left;
        border-bottom: 1px solid #dee2e6;
    }
    table tbody td {
        padding: 12px;
        border-bottom: 1px solid #dee2e6;
        color: #495057;
    }
    .pagination {
        display: flex;
        justify-content: flex-end;
        align-items: center;
        margin-top: 20px;
    }
    .pagination select {
        padding: 8px;
        border: 1px solid #dee2e6;
        border-radius: 4px;
        margin-right: 20px;
    }
    .pagination .page-number {
        display: flex;
        align-items: center;
    }
    .pagination .page-number a {
        padding: 8px 12px;
        margin: 0 4px;
        border: 1px solid #dee2e6;
        border-radius: 4px;
        text-decoration: none;
        color: #495057;
    }
    .pagination .page-number a.active {
        background-color: #6f42c1;
        color: white;
        border: none;
    }
</style>