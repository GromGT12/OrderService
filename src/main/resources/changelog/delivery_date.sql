INSERT INTO public.delivery(id, order_id, product_id, quantity, total_price, delivery_date, delivery_status, delivery_address, client_id, client_name, client_address, delivery_method)
VALUES
    (1, 2786, 1, 2, 15.00, '2023-12-07', 'DELIVERED', '123 Main St, City, Country', 3785, 'John Doe', '123 Main St, City, Country', 'Express'),
    (2, 2787, 2, 1, 10.50, '2023-12-08', 'PROCESSING', '456 Elm St, Town, Country', 3875, 'Jane Smith', '456 Elm St, Town, Country', 'Standard'),
    (3, 2788, 3, 3, 30.00, '2023-12-09', 'SHIPPED', '789 Oak St, Village, Country', 3982, 'Bob Johnson', '789 Oak St, Village, Country', 'Express');
