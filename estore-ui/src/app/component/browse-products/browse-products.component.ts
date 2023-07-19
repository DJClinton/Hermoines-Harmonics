import { Component } from '@angular/core';
import { ProductService } from '../../service/product.service';
import { Product } from '../../type';

@Component({
  selector: 'app-browse-products',
  templateUrl: './browse-products.component.html',
  styleUrls: ['./browse-products.component.scss'],
})
export class BrowseProductsComponent {
  products: Product[] = [];

  constructor(private productService: ProductService) {}

  ngOnInit() {
    this.getProducts();
  }

  getProducts() {
    this.productService.getProducts().subscribe((products) => {
      this.products = products;
    });
  }
}
