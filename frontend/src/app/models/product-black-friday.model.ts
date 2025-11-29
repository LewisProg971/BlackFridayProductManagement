import { ProductType } from "./product-type.enum";

export interface ProductBlackFriday {
    id: number;
    nomCommercial: string;
    type: ProductType;
    prixVenteInitial: number;
    prixFinal: number;
}
