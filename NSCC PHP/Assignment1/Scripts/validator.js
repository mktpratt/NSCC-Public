/**
 * Created by inet2005 on 9/29/14.
 */

Date.prototype.dateToNumString = function () {

    function padZero(obj) {
        obj = obj + '';
        if (obj.length == 1)
            obj = "0" + obj
        return obj;
    }

    var output = "";
    output += this.getFullYear();
    output += padZero(this.getMonth()+1);
    output += padZero(this.getDate());

    return output;
}



function validateEmployeeForm()
    {
        var firstName = document.forms["createEmployee"]["firstName"].value;
        var lastName = document.forms["createEmployee"]["lastName"].value;
        var gender = document.forms["createEmployee"]["gender"].value;
        var hireDate = document.forms["createEmployee"]["hireDate"].value;
        var birthDate = document.forms["createEmployee"]["birthDate"].value;
        var birthDateDate = new Date(birthDate);
        var birthDateString = birthDateDate.dateToNumString();
        var hireDateDate = new Date(hireDate)
        var hireDateString = hireDateDate.dateToNumString();
        var todayDate = new Date();
        var todayDateString = todayDate.dateToNumString();

        var test = true;

        // RegEx
        var nameRegEx = new RegExp(/^[A-Z][A-Za-z]+$/);
        var dateRegEx = new RegExp(/^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/);

        if (gender != "M" && gender != "F") {
            document.getElementById('genderSpan').style.color='red';
            document.getElementById('genderSpan').innerHTML='Must be "M" or "F".';
            test = false;
        }
        else {
            document.getElementById('genderSpan').innerHTML='';
        }

        // First name RegEx
        if (nameRegEx.test(firstName) == false) {
            document.getElementById('firstNameSpan').style.color='red';
            document.getElementById('firstNameSpan').innerHTML='First letter must be capitalized and have no non-letters.';
            test = false;
        }
        else {
            document.getElementById('firstNameSpan').innerHTML="";
        }
        // Last name RegEx
        if (nameRegEx.test(lastName) == false) {
            document.getElementById('lastNameSpan').style.color='red';
            document.getElementById('lastNameSpan').innerHTML='First letter must be capitalized and have no non-letters.';
            test = false;
        }
        else {
            document.getElementById('lastNameSpan').innerHTML="";
        }
        // Hire date RegEx
        if (dateRegEx.test(hireDate) == false) {
            document.getElementById('hireDateSpan').style.color='red';
            document.getElementById('hireDateSpan').innerHTML='Must follow "YYYY-MM-DD" format.';
            test = false;
        }
        else {
            document.getElementById('hireDateSpan').innerHTML="";
        }
        // Birth date RegEx
        if (dateRegEx.test(birthDate) == false) {
            document.getElementById('birthDateSpan').style.color='red';
            document.getElementById('birthDateSpan').innerHTML='Must follow "YYYY-MM-DD" format.';
            test = false;
        }
        else {
            document.getElementById('birthDateSpan').innerHTML="";
        }

        // Check for valid hire date
        if (hireDateString > todayDateString || hireDate <= 0) {
            document.getElementById('hireDateSpan').style.color='red';
            document.getElementById('hireDateSpan').innerHTML='Date must be in past! (YYYY-MM-DD)';
            test = false;
        }
        else {
            document.getElementById('hireDateSpan').innerHTML="";
        }
        // Check for valid birth date
        if (birthDateString > todayDateString || birthDateString == null || birthDateString <= 0) {
            document.getElementById('birthDateSpan').style.color='red';
            document.getElementById('birthDateSpan').innerHTML='Date must be in past! (YYYY-MM-DD)';
            test = false;
        }
        else {
            document.getElementById('birthDateSpan').innerHTML="";
        }



        if (test == false) {
            return false;
        }
        else {
            return true;
        }





}

