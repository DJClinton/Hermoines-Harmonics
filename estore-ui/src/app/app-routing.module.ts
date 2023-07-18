import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductDetailComponent } from './screen/product-detail/product-detail.component';
import { InventoryControlComponent } from './inventory-control/inventory-control.component';

const routes: Routes = [
  { path: 'product/:id', component: ProductDetailComponent },
  { path: 'inventory', component: InventoryControlComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
