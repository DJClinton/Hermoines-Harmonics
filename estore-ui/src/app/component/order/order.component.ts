import { ChangeDetectionStrategy, Component, Input, SimpleChanges, OnChanges } from '@angular/core';
import { ProductService } from 'src/app/service/product.service';
import { Order, Product, OrderStatus } from 'src/app/type';

import {DateTime} from 'luxon';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.scss'],
  changeDetection: ChangeDetectionStrategy.Default,
})
export default class OrderComponent implements OnChanges {
  @Input() order?: Order;
  dateFormatted: string = "";
  total = 0;
  products: Product[] = [];

  constructor(private productService: ProductService) {}

  ngOnChanges(changes: SimpleChanges): void {
    if (this.order === undefined) {
      return;
    }

    this.dateFormatted = DateTime.fromMillis(this.order.date).toLocaleString(DateTime.DATE_SHORT);

    this.productService.getProductsByIds(this.order.productId).subscribe((products) => {
      this.products = products;
      this.total = this.products.reduce((acc, product) => acc + product.price, 0);
    });
  }


  trackProductItem(index: number, product: Product): number {
    return product.id;
  }
}
