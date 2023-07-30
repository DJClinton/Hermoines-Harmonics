import { Token } from '@angular/compiler';
import { Component } from '@angular/core';
import { BuyerInfoService } from 'src/app/buyerInfo.service';
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
  constructor(private infoService: BuyerInfoService, private auth: AuthorizationService){}

  ngOnInit(): void {
    this.getCart();
  }

  getCart(): void{
    const token = localStorage.getItem('token')
    if(token!=null){
      this.userID = token.split(':')[2];
      this.infoService.getBuyerInfosByUserId(this.userID).subscribe(
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