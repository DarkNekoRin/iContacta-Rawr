/**
 * 
 */


$(document ).ready(function() {	
	//inicio();

	$("#divFormulario").show();$("#divTblOutput").hide();
	
	$(".alert").hide();
	$('#exportar').click(function(){	
		
	});
	
	
	
	
	
	
	$('#procesar').click(function(){	
		console.log("procesar1"); 

        
        var form = $('#fileUploadForm')[0];

        var data = new FormData(form);

        //stop submit the form, we will post it manually.
        event.preventDefault();

        // Get form
        var form = $('#fileUploadForm')[0];

		// Create an FormData object 
        var data = new FormData(form);
        
        if(data.get("file").name.length>0){
    		// If you want to add an extra field for the FormData
            //data.append("CustomField", "This is some extra data, testing");
    		// disabled the submit button
        	
        	
			swal({   
				title: "Procesando",   
				text: "Espere.",   				
				showConfirmButton: false
			});
        	
        	
        	$("#procesar").prop("disabled", true);
            $.ajax({
                type: "POST",
                enctype: 'multipart/form-data',
                url: "/upload",
                data: data,
                processData: false,
                contentType: false,
                cache: false,
                timeout: 600000,
                success: function (data) {                	
                    console.log("SUCCESS : ", data);
                    $("#procesar").prop("disabled", false);
                    $(".sweet-alert").hide();
                    $(".sweet-overlay").hide();
                    $('#idSolicitud').val(data.values.idSolicitud);
                    //procesoCorrecto();
                    //window.location = "uploadStatus";
                    table.ajax.reload();
                    $("#divFormulario").hide();$("#divTblOutput").show();
                },
                error: function (e) {
                    console.log("ERROR : ", e);
                    $("#procesar").prop("disabled", false);
                    $(".sweet-alert").hide();
                    $(".sweet-overlay").hide();
                    $(".alert").show();
                    
                }
            });
        }else{
            Command: toastr["warning"]("RAWR", "Sube un archivo txt")

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
	
	var table= $('#tblOutput').DataTable( {
    	"bJQueryUI":true,
        "processing": true,
        "responsive": true,
        "bSort":false,
        "bPaginate":true,
        "dom": '<"row" <"col-sm-12" t> ><"row" <"col-sm-3"l> <"col-sm-4"i> <"col-sm-5"p>>',
        "iDisplayLength": 10,
        "sPaginationType" : 'full_numbers',
        "ajax": {
            "url": './mostrarSalida',
            "type":'GET',
            "data": function (d) {
            	console.log("llamadaAjax"); 
                d.filtroIdSolicitud = $('#idSolicitud').val();
            }
          },
        "serverSide": true,
        "columns": [
            { "data": "tipoDocumento" },
            { "data": "documento" },
            { "data": "apePaterno",render: function (data, type, row ) {            		
                return row.apePaterno +" "+row.apeMaterno+" "+row.primerNombre +" "+row.segundoNombre;
            } },
            { "data": "numCelular1" },
            { "data": "numCelular2" },
            { "data": "numCelular3" }
        ],
        "select": true
    } );
	
})