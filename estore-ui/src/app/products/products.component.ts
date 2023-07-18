import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service'
import { Product } from '../product';
@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {
  products: Product[] = [];

  constructor(private productService: ProductService) {}

  ngOnInit() {
    this.getProducts();
  }

  getProducts() {
    this.productService.getProducts().subscribe(products => {
      this.products = products;
    });
  }

  addProduct(name: string, price: number, quantity: number) {
    const id: number = 0; // Server will handle the actual product ID, replacing this temporary value.
    const newProduct: Product = {id, name, price, quantity};
    this.productService.addProduct(newProduct).subscribe((product: Product) => {
      this.products.push(product);
      this.getProducts(); // Refreshes product list
      console.log("Product created successfully")
    });
  }

  updateProduct(product: Product) {
    this.productService.updateProduct(product).subscribe(() => {
      this.getProducts(); // Refreshes product list
      console.log("Product updated successfully")
    });
  }

  deleteProduct(id: number) {
    this.productService.deleteProduct(id).subscribe(() => {
      this.getProducts(); // Refreshes product list
      console.log("Product deleted successfully")
    });
  }
}
