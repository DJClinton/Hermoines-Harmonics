import { Component } from '@angular/core';
import { Order } from '../../type';
import { OrderService } from 'src/app/service/order.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-past-orders',
  templateUrl: './past-orders.component.html',
  styleUrls: ['./past-orders.component.scss']
})
export class PastOrdersComponent {
  pastOrders: Order[] = [];
  order: any;
  constructor(
    private orderService: OrderService, 
    private location: Location
  ){}

  ngOnInit(){
    this.getPastOrders();
  }

  getPastOrders() : void{
      this.orderService.getOrdersofUser().subscribe((pastOrders) => {
        this.pastOrders = pastOrders
        console.log(this.pastOrders);
      })
  }


}
