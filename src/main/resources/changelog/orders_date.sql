INSERT INTO public.orders(id, client_id, order_date, total_price, status, delivery_address, payment_status)
VALUES
    (1, 3785, '2023-12-07', 15.00, 'DELIVERED', '123 Main St, City, Country', 'Paid'),
    (2, 3875, '2023-12-08', 10.50, 'PROCESSING', '456 Elm St, Town, Country', 'Pending'),
    (3, 3982, '2023-12-09', 30.00, 'SHIPPED', '789 Oak St, Village, Country', 'Paid');
