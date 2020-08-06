import { ReportDTO } from './report-dto';
import { FeaturesDTO } from './features-dto';
import { LocationDTO } from './location-dto';
import { ContactInfoDTO } from './contact-dto';

export class RestaurantDto {

    id: string;
    name: string;
    description: string;
    photo: string;
    price: string;
    cuisine: string[];
    location: LocationDTO;
    contact: ContactInfoDTO;
    closed: boolean;
    openNowText: string;
    dietaryRestrictions: string[];
    features: FeaturesDTO;
    size: number;
    reportDTO: ReportDTO;
    alarmCreation: Date;
    averageGrade: number;

}
