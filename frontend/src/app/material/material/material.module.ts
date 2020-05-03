import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  MatButtonModule, MatInputModule, MatIconModule, MatCardModule, MatNativeDateModule,
  MatDatepickerModule, MatListModule, MatSnackBarModule, MAT_SNACK_BAR_DEFAULT_OPTIONS,
  MatSelectModule, MatTooltipModule, MatToolbarModule, MatTabsModule, MatTableModule, MatPaginatorModule,
  MatMenuModule, MatExpansionModule, MatSortModule, MatAutocompleteModule, MatSlideToggleModule,
  MatRadioModule, MatDialogModule, MatCheckboxModule
} from '@angular/material';

const MaterialComponents = [
  MatButtonModule,
  MatCardModule,
  MatInputModule
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ],
  exports: [
    MaterialComponents
  ]
})
export class MaterialModule { }
