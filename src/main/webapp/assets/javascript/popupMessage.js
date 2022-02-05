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

  case "deleteSucess":
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
			title: 'Successfully Deleted'
			});
			
    break;

	case "deleteFailure":
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
			title: 'Unable To Delete Product Something Went Wrong'
			});
			
	break;			
			
	case "productUpdated":
		Swal.fire({
			  icon: 'success',
			  title: 'price changed',
			  showConfirmButton: false,
			  timer: 2000})
	break;
	
	case "productAdded":
	
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
			title: 'New Product Added Successfully'
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