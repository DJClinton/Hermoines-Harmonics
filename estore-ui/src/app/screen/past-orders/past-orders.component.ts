import { Component } from '@angular/core';
import { Order } from '../../type';
import { OrderService } from 'src/app/service/order.service';

@Component({
  selector: 'app-past-orders',
  templateUrl: './past-orders.component.html',
  styleUrls: ['./past-orders.component.scss']
})
export class PastOrdersComponent {
  pastOrders: Order[] = [];
  constructor(private orderService: OrderService){}
}
