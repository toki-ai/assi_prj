<style>
    body {
        font-family: Arial, sans-serif;
    }

    .container1 {
        width: 700px;
        margin: 10px auto;
        padding: 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
        background-color: #f9f9f9;
    }

    .image-upload {
        width: 100%;
        height: 150px;
        border: 1px dashed #ccc;
        border-radius: 5px;
        display: flex;
        justify-content: center;
        align-items: center;
        margin-bottom: 20px;
    }

    .image-upload img {
        width: 100px;
        height: 100px;
    }

    .image-upload input {
        display: none;
    }

    .form-group {
        margin-bottom: 20px;
    }

    .form-group label {
        display: block;
        margin-bottom: 5px;
    }

    .form-group input[type="text"] {
        width: calc(100% - 10px);
        padding: 5px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    .required {
        color: red;
    }

    .checkbox-label {
        margin-left: 5px;
    }

    .toggle-group {
        display: flex;
        align-items: center;
        margin-bottom: 20px;
    }

    .toggle-switch {
        position: relative;
        display: inline-block;
        width: 34px;
        height: 20px;
    }

    .toggle-switch input {
        display: none;
    }

    .slider {
        position: absolute;
        cursor: pointer;
        top: 0;
        left: 0;
        right: 0;
        bottom: 0;
        background-color: #ccc;
        transition: .4s;
        border-radius: 34px;
    }

    .slider:before {
        position: absolute;
        content: "";
        height: 12px;
        width: 12px;
        left: 4px;
        bottom: 4px;
        background-color: white;
        transition: .4s;
        border-radius: 50%;
    }

    input:checked + .slider {
        background-color: #4caf50;
    }

    input:checked + .slider:before {
        transform: translateX(14px);
    }

    .toggle-label {
        margin-left: 10px;
    }

    .form-buttons {
        display: flex;
        justify-content: space-between;
    }

    .form-buttons button {
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }

    .save-button {
        background-color: #ff7f00;
        color: white;
    }

    .save-add-button {
        background-color: #4a90e2;
        color: white;
    }

    .cancel-button {
        background-color: #ccc;
        color: black;
    }

</style>