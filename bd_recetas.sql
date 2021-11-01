select * from ingredientes ing;
--                                                                                                                                       calorias, grasa, proteina, agua, colesterol, calcio, hierro, zinc
INSERT INTO ingredientes (id, nombre, descripcion, calorias, grasa, proteina, agua, colesterol, calcio, hierro, zinc) VALUES(1, 'Agua', '', 0, 0, 0, 1000, 0, 0, 0, 0);
INSERT INTO ingredientes (id, nombre, descripcion, calorias, grasa, proteina, agua, colesterol, calcio, hierro, zinc) VALUES(2, 'Aceite de girasol', '', 887, 99.9, 0, 0, 0, 0, 0, 0);
INSERT INTO ingredientes (id, nombre, descripcion, calorias, grasa, proteina, agua, colesterol, calcio, hierro, zinc) VALUES(3, 'Aceite de oliva', '', 887, 99.9, 0, 0.1, 0, 0, 0, 0);
INSERT INTO ingredientes (id, nombre, descripcion, calorias, grasa, proteina, agua, colesterol, calcio, hierro, zinc) VALUES(4, 'Ajo', '', 117, 0.23, 3.9375, 70.4, 0, 17.8, 1.2, 1.1);
INSERT INTO ingredientes (id, nombre, descripcion, calorias, grasa, proteina, agua, colesterol, calcio, hierro, zinc) VALUES(5, 'Arroz', '', 387, 0.9, 7, 5.9, 0, 10, 0.5, 0.2);
INSERT INTO ingredientes (id, nombre, descripcion, calorias, grasa, proteina, agua, colesterol, calcio, hierro, zinc) VALUES(6, 'Azúcar', '', 408, 0, 0, 0, 0, 1, 0.1, 0.1);
INSERT INTO ingredientes (id, nombre, descripcion, calorias, grasa, proteina, agua, colesterol, calcio, hierro, zinc) VALUES(7, 'Brécol hervido', '', 24, 0.8, 3.1, 91.1, 0, 40, 1, 0.4);
INSERT INTO ingredientes (id, nombre, descripcion, calorias, grasa, proteina, agua, colesterol, calcio, hierro, zinc) VALUES(8, 'Leche de vaca entera', '', 65, 3.8, 3.06, 88.4, 14, 124, 0.09, 0.38);
INSERT INTO ingredientes (id, nombre, descripcion, calorias, grasa, proteina, agua, colesterol, calcio, hierro, zinc) VALUES(9, 'Leche semidesnatada', '', 46, 1.6, 3.2, 89.6, 5, 114, 0.04, 0.4);
INSERT INTO ingredientes (id, nombre, descripcion, calorias, grasa, proteina, agua, colesterol, calcio, hierro, zinc) VALUES(10, 'Pasta integral', '', 122, 0.9, 4.7, 63.7, 0, 15, 1.06, 0.81);
INSERT INTO ingredientes (id, nombre, descripcion, calorias, grasa, proteina, agua, colesterol, calcio, hierro, zinc) VALUES(11, 'Sal', '', 0, 0, 0, 0, 0, 29, 0.2, 0);

select * from cocineros;

INSERT INTO cocineros (id, nombre, apellido, create_at, email) VALUES(1, 'Juan', 'Díaz', '2021-10-30', 'juan@mail.com');
INSERT INTO cocineros (id, nombre, apellido, create_at, email) VALUES(2, 'María', 'Pedroño', '2021-11-1', 'maria@mail.com');
INSERT INTO cocineros (id, nombre, apellido, create_at, email) VALUES(3, 'Elvira', 'Hermoso', '2021-10-30', 'elvira@mail.com');

SELECT * FROM recetas;

INSERT INTO recetas (id, nombre, descripcion, create_at, cocinero_id) VALUES(1, 'Arroz con leche', '', '2021-10-30', 1);

SELECT * FROM recetas_items;

INSERT INTO recetas_items (id, cantidad, ingrediente_id, receta_id) VALUES(1, 100, 5, 1);