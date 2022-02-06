/**
 * 
 */
 // var check = document.currentScript.getAttribute('status');
function showMessage(check)
{    

 switch(check) {
	
  case "loginSucess":
	console.log("admin login");
   var toastMixin = Swal.mixin({
        toast: true,
        icon: 'success',
        title: 'General Title',
        animation: false,
        position: 'top-right',
        showConfirmButton: false,
        timer: 1500,
        timerProgressBar: true,
        didOpen: (toast) => {
        toast.addEventListener('mouseenter', Swal.stopTimer)
        toast.addEventListener('mouseleave', Swal.resumeTimer)
        }
        });
    
       
        toastMixin.fire({
        animation: true,
        title: 'Login Sucessfull'
        });
    
    break;
    case "registerSucces":
	console.log("admin login");
   var toastMixin = Swal.mixin({
        toast: true,
        icon: 'success',
        title: 'General Title',
        animation: false,
        position: 'top-right',
        showConfirmButton: false,
        timer: 1500,
        timerProgressBar: true,
        didOpen: (toast) => {
        toast.addEventListener('mouseenter', Swal.stopTimer)
        toast.addEventListener('mouseleave', Swal.resumeTimer)
        }
        });
    
       
        toastMixin.fire({
        animation: true,
        title: 'Register Sucessfull'
        });
    
    break;
     case "pending":
	console.log("admin login");
   var toastMixin = Swal.mixin({
        toast: true,
        icon: 'success',
        title: 'General Title',
        animation: false,
        position: 'top-right',
        showConfirmButton: false,
        timer: 1500,
        timerProgressBar: true,
        didOpen: (toast) => {
        toast.addEventListener('mouseenter', Swal.stopTimer)
        toast.addEventListener('mouseleave', Swal.resumeTimer)
        }
        });
    
       
        toastMixin.fire({
        animation: true,
        title: 'your request accepted and status is pending'
        });
    
    break;
     case "approvedRequest":
	console.log("admin login");
   var toastMixin = Swal.mixin({
        toast: true,
        icon: 'success',
        title: 'General Title',
        animation: false,
        position: 'top-right',
        showConfirmButton: false,
        timer: 1500,
        timerProgressBar: true,
        didOpen: (toast) => {
        toast.addEventListener('mouseenter', Swal.stopTimer)
        toast.addEventListener('mouseleave', Swal.resumeTimer)
        }
        });
    
       
        toastMixin.fire({
        animation: true,
        title: 'can t delete the request it is approved'
        });
    
    break;

  case "Booking":
   var toastMixin = Swal.mixin({
			toast: true,
			icon: 'success',
			title: 'General Title',
			animation: false,
			position: 'top-right',
			showConfirmButton: false,
			timer: 1500,
			timerProgressBar: true,
			didOpen: (toast) => {
			toast.addEventListener('mouseenter', Swal.stopTimer)
			toast.addEventListener('mouseleave', Swal.resumeTimer)
			}
			});

			
			toastMixin.fire({
			animation: true,
			title: 'Booking Successfully '
			});
			
    break;

	case "bookingDate":
   var toastMixin = Swal.mixin({
			toast: true,
			icon: 'success',
			title: 'General Title',
			animation: false,
			position: 'top-right',
			showConfirmButton: false,
			timer: 5000,
			timerProgressBar: true,
			didOpen: (toast) => {
			toast.addEventListener('mouseenter', Swal.stopTimer)
			toast.addEventListener('mouseleave', Swal.resumeTimer)
			}
			});

		
			toastMixin.fire({
			animation: true,
			title: 'your previous donated date is with in 90 days,so please donate after 90 days '
			});
			
	break;	
	case "RequestDeleted":
   var toastMixin = Swal.mixin({
			toast: true,
			icon: 'success',
			title: 'General Title',
			animation: false,
			position: 'top-right',
			showConfirmButton: false,
			timer: 1500,
			timerProgressBar: true,
			didOpen: (toast) => {
			toast.addEventListener('mouseenter', Swal.stopTimer)
			toast.addEventListener('mouseleave', Swal.resumeTimer)
			}
			});

		
			toastMixin.fire({
			animation: true,
			title: 'Request Cancel '
			});
			
	break;			
			
	case "productUpdated":
		Swal.fire({
			  icon: 'success',
			  title: 'price changed',
			  showConfirmButton: false,
			  timer: 2000})
	break;
	
	case "qualified":
	
	   var toastMixin = Swal.mixin({
			toast: true,
			icon: 'success',
			title: 'General Title',
			animation: false,
			position: 'top-right',
			showConfirmButton: false,
			timer: 1500,
			timerProgressBar: true,
			didOpen: (toast) => {
			toast.addEventListener('mouseenter', Swal.stopTimer)
			toast.addEventListener('mouseleave', Swal.resumeTimer)
			}
			});

			
			toastMixin.fire({
			animation: true,
			title: 'you are qualified '
			});
	break;
	case "InvalidAadharcardNumber":
	
	   var toastMixin = Swal.mixin({
			toast: true,
			icon: 'success',
			title: 'General Title',
			animation: false,
			position: 'top-right',
			showConfirmButton: false,
			timer: 1500,
			timerProgressBar: true,
			didOpen: (toast) => {
			toast.addEventListener('mouseenter', Swal.stopTimer)
			toast.addEventListener('mouseleave', Swal.resumeTimer)
			}
			});

			
			toastMixin.fire({
			animation: true,
			title: 'Invalid Aadharcard Number '
			});
	break;
	case "forgotpassword":
	
	   var toastMixin = Swal.mixin({
			toast: true,
			icon: 'success',
			title: 'General Title',
			animation: false,
			position: 'top-right',
			showConfirmButton: false,
			timer: 1500,
			timerProgressBar: true,
			didOpen: (toast) => {
			toast.addEventListener('mouseenter', Swal.stopTimer)
			toast.addEventListener('mouseleave', Swal.resumeTimer)
			}
			});

			
			toastMixin.fire({
			animation: true,
			title: 'password changed'
			});
	break;
	
	case "noDate":
	
		Swal.fire({
			  icon: 'error',
			  title: 'you are the new comer',
			  showConfirmButton: false,
			  timer: 2000})
	
	break;
  default:
      alert("Invalid");
    
	}
	
}