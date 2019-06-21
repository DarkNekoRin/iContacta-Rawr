/**
 * 
 */
        var pageIndex = Number(${pageIndex});

        var totalCount = Number(${totalCount});
$(document ).ready(function() {	
	
	var table= $('#tblUsuario').DataTable( {
    	"bJQueryUI":true,
        "processing": true,
        "responsive": true,
        "bSort":false,
        "bPaginate":false,
        //"scrollCollapse": true,
        //"scrollY":        "300px",
        "dom": '<"row" <"col-sm-12" t> ><"row" <"col-sm-3"l> <"col-sm-4"i> <"col-sm-5"p>>',
        "iDisplayLength": 10,
        "sPaginationType" : 'full_numbers',
        "ajax": {
            "url": './queryAll',
            "type":'GET',
            "data": function (d) {
            	console.log("llamadaAjax"); 
            }
          },
        "serverSide": true,
        "columns": [
            { "data": "id" },
            { "data": "username" },
            { "data": "apePaterno" },
            { "data": "apeMaterno" },
            { "data": "nombres" },
            { "data": "bloqueado" },
            { "data": "ultimaSesion" },
            { "data": "resetPassword" }           
        ],
        "select": true
    } );
	

	
	$('#procesarVenta').click(function(){	
		console.log("buscar");
			swal({   
				title: "Procesando",   
				text: "Espere. "    ,	
				showLoaderOnConfirm: true ,
				showConfirmButton: false
			});
	        var form = $('#formVenta')[0];

	        var data = new FormData(form);

	        //stop submit the form, we will post it manually.
	        event.preventDefault();
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "/procesarVenta",
                data: data,
                processData: false,
                contentType: false,
                cache: false,
                timeout: 600000,
                success: function (data) { 
                	swal.close();
                	if(data.estado){
                        console.log("SUCCESS : ", data);
                        $("#procesarCampania").prop("disabled", false);
                        table.ajax.reload();
                	}else{                  
                       
                        $("#procesarCampania").prop("disabled", false);
                        
                        Command: toastr["error"](data.mensaje, "iContacta - Interbank")

                        toastr.options = {
                          "closeButton": false,
                          "debug": false,
                          "newestOnTop": false,
                          "progressBar": false,
                          "rtl": false,
                          "positionClass": "toast-top-right",
                          "preventDuplicates": false,
                          "onclick": null,
                          "showDuration": 300,
                          "hideDuration": 1000,
                          "timeOut": 5000,
                          "extendedTimeOut": 1000,
                          "showEasing": "swing",
                          "hideEasing": "linear",
                          "showMethod": "fadeIn",
                          "hideMethod": "fadeOut"
                        }  
                	}

                },
                error: function (e) {
                    console.log("ERROR : ", e);
                    swal.close();
                    $("#procesarCampania").prop("disabled", false);
                    $('#idTituloGrilla').text("ERROR AL PROCESAR LA DATA");
                    
                    Command: toastr["error"](e, "iContacta - Interbank")

                    toastr.options = {
                      "closeButton": false,
                      "debug": false,
                      "newestOnTop": false,
                      "progressBar": false,
                      "rtl": false,
                      "positionClass": "toast-top-right",
                      "preventDuplicates": false,
                      "onclick": null,
                      "showDuration": 300,
                      "hideDuration": 1000,
                      "timeOut": 5000,
                      "extendedTimeOut": 1000,
                      "showEasing": "swing",
                      "hideEasing": "linear",
                      "showMethod": "fadeIn",
                      "hideMethod": "fadeOut"
                    }                    
                }
            });
        	
        
	});	

})