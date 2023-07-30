import { Token } from '@angular/compiler';
import { Component } from '@angular/core';
import { BuyerInfoService } from 'src/app/service/buyerInfo.service';
import { AuthorizationService } from 'src/app/service/authorization.service';
import { CartServiceService } from 'src/app/service/cart-service.service';

@Component({
  selector: 'app-cart-info',
  templateUrl: './cart-info.component.html',
  styleUrls: ['./cart-info.component.scss']
})
export class CartInfoComponent {
  cart : any
  userID : any
  user: any
  buyerInfo: any
  constructor(private infoService: BuyerInfoService){}

  ngOnInit(): void {
    this.getUser();
  }

  getUser(): void{
    const token = localStorage.getItem('token')
    if(token!=null){
      this.userID = token.split(':')[2];
      this.infoService.getBuyerInfoByUserId(this.userID).subscribe(
        (userData: any) => {
          this.user = userData;
          this.buyerInfo = userData;
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
      this.infoService.getBuyerCart(this.buyerInfo.id).subscribe(
        (cartData: any) => {
          this.cart = cartData;
        },
        (error) => {
          console.error('Error getting cart:', error);
        }
      );
    } else {
      console.error('User not authenticated');
    }
  }
}