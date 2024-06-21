import { UserInfo } from "./user-info";

export interface ProfileInfo
{
    id: number;
    user: UserInfo;
    currentJobTitle: string;
    industry: string;
    summary: string;
    headline: string;
    website: string;
    openForWork: number;
    connections: ConnectionInfo[];
    skills: SkillInfo[];
    experiences: ExperienceInfo[];
    educations: EducationInfo[];
}

export interface SkillInfo
{
    id: number;
    name: string;
}

export interface ExperienceInfo
{
    id: number;
    jobTitle: string;
    companyName: string;
    location: string;
    startDate: string;
    endDate: string;
}

export interface EducationInfo
{
    id: number;
    school: string;
    degree: string;
    filedOfStudy: string;
    startDate: string;
    endDate: string;
}

export interface ConnectionInfo
{
    id: number;
    userId: number;
    username: string;
    firstName: string;
    lastName: string;
    currentJobTitle: string;
    industry: string;
    summary: string;
    headline: string;
    website: string;
    openForWork: number
}