# Test Case 1: Inicio de Sesión Exitoso

*ID del Caso de Prueba:* LOGIN_001

*Funcionalidad:* Inicio de sesión

*Descripción:* Verificar que un usuario con credenciales válidas pueda iniciar sesión exitosamente.

## Precondiciones

- El usuario debe estar en la página de inicio de sesión ([https://www.saucedemo.com/](https://www.saucedemo.com/)).
- Las credenciales válidas deben estar disponibles:
    - *Nombre de usuario:* standard_user
    - *Contraseña:* secret_sauce
- El navegador debe estar en estado inicial, sin usuarios previamente logueados.
- No debe haber problemas de red.

## Datos de Entrada

- *Usuario:* standard_user
- *Contraseña:* secret_sauce

## Pasos

1. Navegar a la página de inicio de sesión ([https://www.saucedemo.com/](https://www.saucedemo.com/)).
2. Verificar que los campos de "Nombre de usuario" y "Contraseña" estén visibles y habilitados.
3. Ingresar el nombre de usuario: standard_user.
4. Ingresar la contraseña: secret_sauce.
5. Verificar que el botón de inicio de sesión esté habilitado.
6. Hacer clic en el botón de inicio de sesión.

## Resultado Esperado

- El usuario debe ser redirigido a la página de inventario ([https://www.saucedemo.com/inventory.html](https://www.saucedemo.com/inventory.html)).
- La URL de la página debe coincidir con la URL de inventario.

## Post-condiciones

- El usuario debe estar logueado correctamente en la página de inventario.
- El estado de la sesión debe persistir para futuras interacciones.

---

# Test Case 2: Inicio de Sesión con Credenciales Inválidas

*ID del Caso de Prueba:* LOGIN_002

*Funcionalidad:* Inicio de sesión

*Descripción:* Verificar que el sistema muestre un mensaje de error cuando un usuario intenta iniciar sesión con credenciales inválidas.

## Precondiciones

- El usuario debe estar en la página de inicio de sesión ([https://www.saucedemo.com/](https://www.saucedemo.com/)).
- Las credenciales inválidas deben estar disponibles:
    - *Nombre de usuario:* standard_user
    - *Contraseña:* wrong_password
- El navegador debe estar en estado inicial, sin usuarios previamente logueados.

## Datos de Entrada

- *Usuario:* standard_user
- *Contraseña:* wrong_password

## Pasos

1. Navegar a la página de inicio de sesión ([https://www.saucedemo.com/](https://www.saucedemo.com/)).
2. Verificar que los campos de "Nombre de usuario" y "Contraseña" estén visibles y habilitados.
3. Ingresar el nombre de usuario: standard_user.
4. Ingresar la contraseña: wrong_password.
5. Verificar que el botón de inicio de sesión esté habilitado.
6. Hacer clic en el botón de inicio de sesión.

## Resultado Esperado

- Debería mostrarse el mensaje de error:

  > "Epic sadface: Username and password do not match any user in this service."

## Post-condiciones

- El usuario no debería estar logueado en la aplicación.
- La página debería permanecer en la pantalla de inicio de sesión.

---

# Test Case 3: Inicio de Sesión con Nombre de Usuario Incorrecto

*ID del Caso de Prueba:* LOGIN_003

*Funcionalidad:* Inicio de sesión

*Descripción:* Verificar que el sistema muestre un mensaje de error cuando se ingrese un nombre de usuario incorrecto.

## Precondiciones

- El usuario debe estar en la página de inicio de sesión ([https://www.saucedemo.com/](https://www.saucedemo.com/)).
- Las credenciales con nombre de usuario incorrecto deben estar disponibles:
    - *Nombre de usuario:* wrong_user
    - *Contraseña:* secret_sauce
- El navegador debe estar en estado inicial, sin usuarios previamente logueados.

## Datos de Entrada

- *Usuario:* wrong_user
- *Contraseña:* secret_sauce

## Pasos

1. Navegar a la página de inicio de sesión ([https://www.saucedemo.com/](https://www.saucedemo.com/)).
2. Verificar que los campos de "Nombre de usuario" y "Contraseña" estén visibles y habilitados.
3. Ingresar el nombre de usuario: wrong_user.
4. Ingresar la contraseña: secret_sauce.
5. Verificar que el botón de inicio de sesión esté habilitado.
6. Hacer clic en el botón de inicio de sesión.

## Resultado Esperado

- Debería mostrarse el mensaje de error:

  > "Epic sadface: Username and password do not match any user in this service."

## Post-condiciones

- El usuario no debería estar logueado en la aplicación.
- La página debería permanecer en la pantalla de inicio de sesión.

---

# Test Case 4: Inicio de Sesión sin Credenciales

*ID del Caso de Prueba:* LOGIN_004

*Funcionalidad:* Inicio de sesión

*Descripción:* Verificar que el sistema muestre un mensaje de error cuando el usuario no ingrese credenciales.

## Precondiciones

- El usuario debe estar en la página de inicio de sesión ([https://www.saucedemo.com/](https://www.saucedemo.com/)).
- No se requieren credenciales válidas para este caso de prueba.

## Pasos

1. Navegar a la página de inicio de sesión ([https://www.saucedemo.com/](https://www.saucedemo.com/)).
2. Verificar que los campos de "Nombre de usuario" y "Contraseña" estén visibles y habilitados.
3. Dejar el campo de "Nombre de usuario" vacío.
4. Dejar el campo de "Contraseña" vacío.
5. Verificar que el botón de inicio de sesión esté habilitado.
6. Hacer clic en el botón de inicio de sesión.

## Resultado Esperado

- Debería mostrarse el mensaje de error:

  > "Epic sadface: Username is required."

## Post-condiciones

- El usuario no debería estar logueado en la aplicación.
- La página debería permanecer en la pantalla de inicio de sesión.

---

# Test Case 5: Inicio de Sesión con Usuario Bloqueado

*ID del Caso de Prueba:* LOGIN_005

*Funcionalidad:* Inicio de sesión

*Descripción:* Verificar que un usuario bloqueado no pueda iniciar sesión y reciba el mensaje de error correspondiente.

## Precondiciones

- El usuario debe estar en la página de inicio de sesión ([https://www.saucedemo.com/](https://www.saucedemo.com/)).
- Las credenciales bloqueadas deben estar disponibles:
    - *Nombre de usuario:* locked_out_user
    - *Contraseña:* secret_sauce
- El navegador debe estar en estado inicial, sin usuarios previamente logueados.

## Datos de Entrada

- *Usuario:* locked_out_user
- *Contraseña:* secret_sauce

## Pasos

1. Navegar a la página de inicio de sesión ([https://www.saucedemo.com/](https://www.saucedemo.com/)).
2. Verificar que los campos de "Nombre de usuario" y "Contraseña" estén visibles y habilitados.
3. Ingresar el nombre de usuario: locked_out_user.
4. Ingresar la contraseña: secret_sauce.
5. Verificar que el botón de inicio de sesión esté habilitado.
6. Hacer clic en el botón de inicio de sesión.

## Resultado Esperado

- Debería mostrarse el mensaje de error:

  > "Epic sadface: Sorry, this user has been locked out."

## Post-condiciones

- El usuario no debería estar logueado en la aplicación.
- La página debería permanecer en la pantalla de inicio de sesión.

---
# Test Case 1: Agregar Producto al Carrito de Compras

*ID del Caso de Prueba:* CART_001

*Funcionalidad:* Agregar productos al carrito

*Descripción:* Verificar que un usuario pueda agregar productos al carrito de compras correctamente.

## Precondiciones

- El usuario debe estar logueado en la página de Swag Labs.
- La página de inventario debe estar visible.

## Pasos

1. Navegar a la página de inventario ([https://www.saucedemo.com/inventory.html](https://www.saucedemo.com/inventory.html)).
2. Seleccionar el producto "Sauce Labs Backpack".
3. Hacer clic en el botón "Add to cart" correspondiente al producto seleccionado.
4. Verificar que el número de artículos en el carrito se actualice a 1.

## Resultado Esperado

- El producto "Sauce Labs Backpack" debe ser agregado al carrito.
- El número de artículos en el carrito debe ser 1.

## Post-condiciones

- El carrito debe contener el producto seleccionado.

---

# Test Case 2: Verificar Productos en el Carrito de Compras

*ID del Caso de Prueba:* CART_002

*Funcionalidad:* Verificar el contenido del carrito

*Descripción:* Asegurarse de que los productos en el carrito y sus precios sean correctos.

## Precondiciones

- El usuario debe estar logueado y haber agregado al menos un producto al carrito.

## Pasos

1. Navegar a la página de inventario.
2. Agregar el producto "Sauce Labs Backpack" al carrito.
3. Hacer clic en el ícono del carrito en la parte superior derecha.
4. Verificar que el número de artículos en el carrito sea 1.
5. Verificar que el precio del producto en el carrito sea correcto.

## Resultado Esperado

- El carrito debe mostrar el producto "Sauce Labs Backpack" con el precio correcto.

## Post-condiciones

- El contenido del carrito debe coincidir con los productos seleccionados.

---

# Test Case 3: Eliminar Producto del Carrito de Compras

*ID del Caso de Prueba:* CART_003

*Funcionalidad:* Eliminar productos del carrito

*Descripción:* Asegurarse de que un usuario pueda eliminar un producto del carrito de compras.

## Precondiciones

- El usuario debe estar logueado y haber agregado al menos un producto al carrito.

## Pasos

1. Navegar a la página de inventario.
2. Agregar el producto "Sauce Labs Backpack" al carrito.
3. Hacer clic en el ícono del carrito.
4. Hacer clic en el botón "Remove" correspondiente al producto en el carrito.
5. Verificar que el carrito esté vacío.
6. Verificar que el número de artículos en el carrito sea 0.

## Resultado Esperado

- El producto debe ser eliminado del carrito.
- El carrito debe estar vacío y reflejar el número de artículos como 0.

## Post-condiciones

- El carrito debe reflejar correctamente el estado actualizado.

---

# Test Case 4: Verificar Precios de los Productos en el Carrito

*ID del Caso de Prueba:* CART_004

*Funcionalidad:* Verificar precios en el carrito

*Descripción:* Asegurarse de que los precios de los productos en el carrito sean correctos.

## Precondiciones

- El usuario debe estar logueado y haber agregado más de un producto al carrito.

## Pasos

1. Navegar a la página de inventario.
2. Agregar los productos "Sauce Labs Backpack" y "Sauce Labs Bike Light" al carrito.
3. Hacer clic en el ícono del carrito.
4. Verificar que los precios de ambos productos en el carrito sean correctos.

## Resultado Esperado

- Los productos en el carrito deben mostrar los precios correspondientes correctamente.

## Post-condiciones

- El carrito debe reflejar los productos y sus precios correctamente.

---

# Test Case 5: Proceder al Pago desde el Carrito de Compras

*ID del Caso de Prueba:* CART_005

*Funcionalidad:* Proceder al pago

*Descripción:* Verificar que un usuario pueda proceder al pago desde el carrito de compras.

## Precondiciones

- El usuario debe estar logueado y tener al menos un producto en su carrito.
- El carrito debe estar visible y contener productos para su compra.

## Pasos

1. Navegar a la página de inventario ([https://www.saucedemo.com/inventory.html](https://www.saucedemo.com/inventory.html)).
2. Agregar un producto al carrito (por ejemplo, Sauce Labs Backpack).
3. Hacer clic en el ícono del carrito en la parte superior derecha.
4. Hacer clic en el botón "Checkout" (Proceder al pago).
5. Verificar que se redirige a la página de pago ([https://www.saucedemo.com/checkout-step-one.html](https://www.saucedemo.com/checkout-step-one.html)).
6. Verificar que los campos para ingresar los datos del usuario (nombre, dirección, etc.) estén visibles y habilitados.

## Resultado Esperado

- El usuario debería ser redirigido a la página de pago.
- El carrito debería mostrarse en la página de pago con los productos correctamente listados.
- Los campos de información de envío y pago deben estar visibles y habilitados.

## Post-condiciones

- El usuario debe estar listo para completar la compra, con los productos en el carrito correctamente reflejados en la página de pago.

---

# Test Case 1: Verificación de Servicios Web en Mercado Libre

*ID del Test Case:* TC-API-001

*Nombre:* Validar que la API de Mercado Libre contenga departamentos.

*Descripción:* Este test case valida que el servicio web de Mercado Libre para la lista de departamentos (GET /menu/departments) devuelva una respuesta válida y que contenga una lista de departamentos.

## Precondiciones

- El servicio web de Mercado Libre está disponible.
- La conexión a internet es estable.

## Datos de Entrada

- *Endpoint:* [https://www.mercadolibre.com.ar/menu/departments](https://www.mercadolibre.com.ar/menu/departments)
- *Método HTTP:* GET

## Pasos a Seguir

1. Realizar una solicitud HTTP GET al endpoint de la API: [https://www.mercadolibre.com.ar/menu/departments](https://www.mercadolibre.com.ar/menu/departments).
2. Capturar la respuesta del servicio.
3. Validar que el código de estado de la respuesta sea 200 (OK).
4. Extraer el campo departments de la respuesta JSON.
5. Verificar que el campo departments:
    - Exista en la respuesta.
    - Contenga una lista con al menos un elemento.
    - Cada elemento de la lista contenga un campo name (nombre del departamento).

## Validaciones

### Código de Estado

- Asegurarse de que el código de respuesta sea 200.
    - *Resultado Esperado:* Código de estado 200.

### Estructura de la Respuesta

- Validar que la respuesta JSON contenga el campo departments.
    - *Resultado Esperado:* El campo departments existe.

### Contenido del Campo departments

- Verificar que departments sea una lista con al menos un elemento.
    - *Resultado Esperado:* La lista tiene al menos un departamento.

### Propiedades de los Departamentos

- Asegurarse de que cada departamento tenga un campo name no vacío.
    - *Resultado Esperado:* Cada departamento tiene un nombre válido.

## Resultado Esperado

La API devuelve una lista válida de departamentos con los siguientes criterios:

- Código de estado 200.
- El campo departments contiene una lista con al menos un departamento.
- Cada departamento tiene un campo name con un valor no vacío.

## Post-condiciones

- El sistema no realiza ninguna modificación sobre el servicio web.
- La prueba finaliza cerrando cualquier conexión activa con el servicio.