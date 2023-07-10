import { Component } from '@angular/core';
import { Product } from '../product';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent {
  product: Product = {
    id: 1,
    name: 'Tuba',
    price: 599.99,
    quantity: 5
  };
}
