INSERT INTO public.shopping_cart(user_id, total_price, created_at, updated_at, status, shipping_address, shipping_method, payment_method, coupon_code)
VALUES
    (101, 45.23, '2024-04-20 14:30:00', '2024-04-20 14:30:00', 'PROCESSING', '123 Main St, City', 'Standard', 'Credit Card', 'DISCOUNT10'),
    (102, 120.50, '2024-04-19 10:00:00', '2024-04-19 10:00:00', 'DELIVERED', '456 Elm St, Town', 'Express', 'PayPal', 'SUMMERSALE'),
    (103, 80.75, '2024-04-18 12:45:00', '2024-04-18 12:45:00', 'SHIPPED', '789 Oak St, Village', 'Standard', 'Debit Card', 'FREESHIP');
