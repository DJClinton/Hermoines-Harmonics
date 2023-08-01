import { Component, OnInit } from '@angular/core';
import { ProductService } from '../../service/product.service';
import { Product } from '../../type';
import { Location } from '@angular/common';

@Component({
  selector: 'app-products',
  templateUrl: './inventory-control.component.html',
  styleUrls: ['./inventory-control.component.scss'],
})
export class InventoryControlComponent implements OnInit {
  products: Product[] = [];

  constructor(
    private productService: ProductService,
    private location: Location
  ) {
    const token = localStorage.getItem('token');
    if (token == null || token !== 'admin:admin') {
      this.location.back();
    }
  }

  ngOnInit() {
    this.getProducts();
  }

  getProducts() {
    this.productService.getProducts().subscribe((products) => {
      this.products = products;
    });
  }

  addProduct(name: string, price: number, quantity: number) {
    const id: number = 0; // Server will handle the actual product ID, replacing this temporary value.
    const newProduct: Product = {
      id,
      name,
      description: '',
      tags: [],
      price,
      quantity,
      numClicks: 0
    };
    this.productService.addProduct(newProduct).subscribe((product: Product) => {
      this.products.push(product);
      this.getProducts(); // Refreshes product list
      console.log('Product created successfully');
    });
  }

  updateProduct(product: Product) {
    this.productService.updateProduct(product).subscribe(() => {
      this.getProducts(); // Refreshes product list
      console.log('Product updated successfully');
    });
  }

  deleteProduct(id: number) {
    this.productService.deleteProduct(id).subscribe(() => {
      this.getProducts(); // Refreshes product list
      console.log('Product deleted successfully');
    });
  }
}
