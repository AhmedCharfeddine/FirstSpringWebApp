var buttons = document.getElementsByClassName("toggle-btn") // toggle buttons
var searchString = document.getElementById("searchBar");

document.addEventListener('DOMContentLoaded', function() {
    buttons[0].onclick = function() {
        document.getElementById("patients-table").style.display = "";
        document.getElementById("staff-table").style.display = "none";
    }
    
    buttons[1].onclick = function() {
        document.getElementById("patients-table").style.display = "none";
        document.getElementById("staff-table").style.display = "";
    }

    searchString.addEventListener("keyup", (e) => {
        const query = e.target.value.toLowerCase();
        var table_id;
        if (buttons[0].classList.contains("active")){
            table_id = "patients-table";
        }
        else{
            table_id = "staff-table";
        }
        const all_items = document.getElementById(table_id).querySelectorAll("tbody > tr");
        console.log(all_items);
        for (let item of all_items){
            var found = false;
            for (let column_value of item.getElementsByTagName("td")){
                if(column_value.innerHTML.toLowerCase().includes(query)){
                    console.log(column_value.innerHTML);
                    found = true;
                    break;
                }
            }
            if (found){
                item.style.display = "";
            }
            else{
                item.style.display = "none";
            }
        }
    })
})