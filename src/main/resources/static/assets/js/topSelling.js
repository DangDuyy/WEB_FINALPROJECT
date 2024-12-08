document.addEventListener("DOMContentLoaded", function() {
    // Lấy danh sách sản phẩm bán chạy nhất
    fetch('/api/top-selling-products')
        .then(response => response.json())
        .then(data => {
            // Duyệt qua các sản phẩm và tạo HTML cho mỗi sản phẩm
            const productList = document.querySelector('.product-list');
            data.forEach(product => {
                const productItem = document.createElement('li');
                productItem.classList.add('flex', 'items-center', 'gap-3');

                // Tạo phần tử chứa thông tin sản phẩm
                const productImage = document.createElement('div');
                productImage.classList.add('flex', 'items-center', 'justify-center', 'w-10', 'h-10', 'rounded-md', 'bg-slate-100');
                const img = document.createElement('img');
                img.src = product.imageLink || '/assets/images/default.png'; // Dùng ảnh mặc định nếu không có ảnh
                img.alt = product.name;
                img.classList.add('h-6');
                productImage.appendChild(img);

                const productInfo = document.createElement('div');
                productInfo.classList.add('overflow-hidden', 'grow');
                const productName = document.createElement('h6');
                productName.classList.add('truncate');
                productName.textContent = product.name;

                const productQuantity = document.createElement('h6');
                productQuantity.classList.add('shrink-0');
                productQuantity.textContent = `Quantity: ${product.quantity}`;

                productInfo.appendChild(productName);
                productInfo.appendChild(productQuantity);

                // Ghép các phần tử lại với nhau
                productItem.appendChild(productImage);
                productItem.appendChild(productInfo);

                // Thêm sản phẩm vào danh sách
                productList.appendChild(productItem);
            });
        })
        .catch(error => console.error('Error fetching top selling products:', error));
});
