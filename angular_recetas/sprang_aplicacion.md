## Creación del Modelo backend

1. Creación de Entidades.
2. Establecer validaciones para los campos de las entidades.
3. Relacionar entidades.
4. Creación de Repositorio y Servicios.
5. Creación del controlador.
6. Captura de errores y envío en la respuesta. Uso de ResponseEntity.
7. Validación de datos de creación / modificación. Uso de anotaciones de validación en entidades (javax.validation). Anotación @Valid e inyección de objeto contenedor de errores BindingResult en controlador.
8. Paginación con objeto Pageable

## Creación del modelo en Angular

1. Creación de los componentes.
2. Creación de las entidades y servicios para las entidades.
3. Enrutamiento entre componentes. (Route, ActivateRoute)
4. Creación de formulario para creación de entidades.
5. Recoger errores del front. Uso de catchError de rxjs/operators.
6. Validaciones en formulario (required, maxlength). Uso de ngModel como objeto contenedor de los mensajes de error.  
    6.1. Validación de campos de formulario
![Validación campos de formulario](./img_recetas/validacion_formularios.png)
    6.2. Desactivación de botón de formulario
![Inhabilitar botones](./img_recetas/validacion_formulario_habilitar_campos_1.png)
![Inhabilitar botones](./img_recetas/validacion_formulario_habilitar_campos_2.png)
7. Manejar errores recibidos desde el backend. Uso de catchErrors:  
    i. En servicio comprobar el status de la respuesta, si es una bad request añadir errores recibidos
    ![Recuperar errores backend](./img_recetas/controlar_errores_backend.png)
    ii. En componente de formulario añadir array con los errores
    ![Recuperar errores backend](./img_recetas/controlar_errores_backend_2.png)
    iii. En vista de formulario añadir lista listando los errores, y desactivar el control de errores de campo de angular.
    ![Recuperar errores backend](./img_recetas/controlar_errores_backend_3.png)
    ![Recuperar errores backend](./img_recetas/controlar_errores_backend_4.png)
8. Formatear valores recibidos desde el back en la vista. Configuración del locale de manera Global  
    i. Formateo de fechas
    ![Formateo de fechas. Opción 1](./img_recetas/formateo_valores_angular_1.png)
    ![Formateo de fechas. Opción 1](./img_recetas/formateo_valores_angular_2.png)
    ![Formateo de fechas. Opción 2](./img_recetas/formateo_valores_angular_3.png)
    ![Formateo de fechas. Opción 2](./img_recetas/formateo_valores_angular_4.png)
    ii. Configuración en el appModule
    ![Formateo de fechas. Opción 2](./img_recetas/formateo_valores_angular_5.png)
    ![Formateo de fechas. Opción 2](./img_recetas/formateo_valores_angular_6.png)
9. Paginación
    1. Cambio a objeto retonado tipo Observable<any>
    ![Paginación](./img_recetas/paginacion_front_1.png)
    ![Paginación](./img_recetas/paginacion_front_2.png)
    ![Paginación](./img_recetas/paginacion_front_3.png)
    ![Paginación](./img_recetas/paginacion_simpleChanges.png)