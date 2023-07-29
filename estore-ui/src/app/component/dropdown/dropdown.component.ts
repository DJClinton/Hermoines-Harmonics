import { Component, ViewChild } from '@angular/core';
import { MatMenuTrigger } from '@angular/material/menu';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dropdown',
  templateUrl: './dropdown.component.html',
  styleUrls: ['./dropdown.component.scss']
})
export class DropdownComponent {
  @ViewChild(MatMenuTrigger) trigger!: MatMenuTrigger;
  
  constructor(private router: Router){}

  openMenu(){
    this.trigger.openMenu();
  }

  redirectToLogout() {
    this.router.navigateByUrl('/logout');
  }
  redirectToAccount() {
    this.router.navigateByUrl('/account');
  }
}


