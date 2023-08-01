import { Component } from '@angular/core';
import { BuyerInfoService } from 'src/app/service/buyerInfo.service';
import { BuyerInfo } from 'src/app/type';
import { Product } from 'src/app/type';


@Component({
  selector: 'app-cart-info',
  templateUrl: './cart-info.component.html',
  styleUrls: ['./cart-info.component.scss']
})
export class CartInfoComponent {
  cart : Product[] = [];
  userId : any
  buyerInfo: any
  buyerId: any
  totalPrice: any
  constructor(private infoService: BuyerInfoService){}

  ngOnInit(): void {
    this.getUser();
  }

  getUser(): void{
    const token = localStorage.getItem('token')
    if(token!=null){
      this.userId = token.split(':')[2];
      this.infoService.getBuyerInfoByUser().subscribe(
        (data: BuyerInfo) => {
          this.buyerInfo = data;
          this.buyerId = this.buyerInfo.id;
          this.userId = this.buyerInfo.userId;
          this.getCart();
        },
        (error) => {
          console.error('Error getting cart:', error);
        }
      );
    } else {
      console.error('User not authenticated');
    }
  }
  
  getCart(): void{
    const token = localStorage.getItem('token');
    if(token!=null && this.buyerInfo){
      console.log(this.buyerInfo.id)
      this.infoService.getBuyerCart().subscribe(
        (cartData: any) => {
          this.cart = cartData;
          this.getCartTotal();
        },
        (error) => {
          console.error('Error getting cart:', error);
        }
      );
    } else {
      console.error('User not authenticated');
    }
  }
  getCartTotal(): void{
    this.totalPrice = 0;
    this.cart.forEach(product => {
      this.totalPrice+=product.price;
    });
  }
}