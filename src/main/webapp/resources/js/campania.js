/**
 * 
 */

$(document ).ready(function() {	

	$(".alert").hide();	
	$('#idSolicitud').val("");
	$('.aLink').attr('href','#');
	
	var table= $('#tblOutput').DataTable( {
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
            "url": './mostrarCampania',
            "type":'GET',
            "data": function (d) {
            	console.log("llamadaAjax"); 
                d.filtroCodCampania = $('#codCampania').val();
            }
          },
        "serverSide": true,
        "columns": [
            { "data": "formulario" },
            { "data": "codigoFb" },
            { "data": "dni" },
            { "data": "fecha" }
        ],
        "select": true
    } );
	

	
	$('#procesarCampania').click(function(){	
		console.log("buscar"); 
debugger;
        var codCampania=$("#txtCampania").val();
        
        if(codCampania.length>0){
    		// If you want to add an extra field for the FormData
            //data.append("CustomField", "This is some extra data, testing");
    		// disabled the submit button
        	        		 
			swal({   
				title: "Procesando",   
				text: "Espere. "    ,	
				showLoaderOnConfirm: true ,
				showConfirmButton: false
			});
//        	
        	$("#procesarCampania").prop("disabled", true);
        	var data = {"filtroCodCampania":codCampania}
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "/procesar",
                data:JSON.stringify(data),
  			    dataType: 'json',
  			    timeout: 600000,
                success: function (data) {  
                	swal.close();
                	if(data.estado){
                        console.log("SUCCESS : ", data);
                        $("#procesarCampania").prop("disabled", false);
                    	//data.values.idSolicitud="B28219201812271823";
                        table.ajax.reload();
                        $('#idTituloGrilla').text("CAMPA&Ntilde;A: "+codCampania); 
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
                	debugger;
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
        }else{
            Command: toastr["warning"]("iContacta - Interbank", "Ingresa Valor")

    		toastr.options = {
    		  "closeButton": false,
    		  "debug": false,
    		  "newestOnTop": false,
    		  "progressBar": true,
    		  "rtl": false,
    		  "positionClass": "toast-top-right",
    		  "preventDuplicates": false,
    		  "onclick": null,
    		  "showDuration": 300,
    		  "hideDuration": 1000,
    		  "timeOut": 50000,
    		  "extendedTimeOut": 1000,
    		  "showEasing": "swing",
    		  "hideEasing": "linear",
    		  "showMethod": "fadeIn",
    		  "hideMethod": "fadeOut"
    		}
        } 	
        
	});	
	
})