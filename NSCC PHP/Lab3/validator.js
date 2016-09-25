/**
 * Created by inet2005 on 9/29/14.
 */

function validateForm()
{
    var fNameText = document.forms["myForm"]["fName"].value;
    var lNameText = document.forms["myForm"]["lName"].value;
    var address1Text = document.forms["myForm"]["address1"].value;
    var address2Text = document.forms["myForm"]["address2"].value;
    var emailText = document.forms["myForm"]["email"].value;
    var termsAgreement = document.forms["myForm"]["termsAgreement"].checked;
    var test = true;

    if (fNameText == null || fNameText == "")
    {
        document.getElementById('fName').style.borderColor='red';
        test = false;
    }
    else
    {
        document.getElementById('fName').style.removeProperty('border');
    }


    if (lNameText == null || lNameText == "")
    {
        document.getElementById('lName').style.borderColor='red';
        test = false;
    }
    else
    {
        document.getElementById('lName').style.removeProperty('border');
    }


    if (address1Text == null || address1Text == "")
    {
        document.getElementById('address1').style.borderColor='red';
        test = false;
    }
    else
    {
        document.getElementById('address1').style.removeProperty('border');
    }


    if (address2Text == null || address2Text == "")
    {
        document.getElementById('address2').style.borderColor='red';
        test = false;
    }
    else
    {
        document.getElementById('address2').style.removeProperty('border');
    }

    if (emailText == null || emailText == "")
    {
        document.getElementById('email').style.borderColor='red';
        test = false;
    }
    else
    {
        document.getElementById('email').style.removeProperty('border');
    }

    if(termsAgreement == false)
    {
        document.getElementById('agreeSpan').style.color='red';
        document.getElementById('agreeSpan').innerHTML='Must agree to terms and conditions.';
        test = false;
    }
    else
    {
        document.getElementById('agreeSpan').innerHTML='';
    }


    if (test == false)
    {
        return false;
    }
    else
    {
        return true;
    }

}
