import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatInputModule } from '@angular/material/input';
@NgModule({
  declarations: [],
  imports: [CommonModule, MatButtonModule, MatExpansionModule, MatInputModule],
  exports: [MatButtonModule, MatExpansionModule, MatInputModule]
})
export class MaterialModule {}
