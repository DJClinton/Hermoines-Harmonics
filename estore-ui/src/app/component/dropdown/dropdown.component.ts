import { Component, ViewChild } from '@angular/core';
import { MatMenuTrigger } from '@angular/material/menu';
import { Router } from '@angular/router';
import { BuyerInfoService } from 'src/app/service/buyerInfo.service';
import { BuyerInfo } from 'src/app/type';

@Component({
  selector: 'app-dropdown',
  templateUrl: './dropdown.component.html',
  styleUrls: ['./dropdown.component.scss']
})
export class DropdownComponent {
  @ViewChild(MatMenuTrigger) trigger!: MatMenuTrigger;
  
  constructor(private router: Router, private buyerInfoService: BuyerInfoService){}

  openMenu(){
    this.trigger.openMenu();
  }

  //TODO: RYAN FIX REDIRECTTOMYACCOUNT

  redirectToMyAccount() {
    this.buyerInfoService.getBuyerInfoByUser().subscribe((data: BuyerInfo) => {
      if(data != null) {
        console.log(data.id);
        this.router.navigateByUrl('/account/' + data.id);
      }
    });
  }
  redirectToLogout(){
    this.router.navigateByUrl("/logout")
  }
  redirectTo(path: string) {
    this.router.navigateByUrl('/' + path);
  }
  isAdmin(): boolean {
    return localStorage.getItem("token") == 'admin:admin';
  }
  redirectToCart(){
    this.router.navigateByUrl('/cart')
  }
}


