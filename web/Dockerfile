# Build stage
FROM node:22.2.0 AS build
WORKDIR /app
COPY package*.json ./
RUN npm install --force
COPY . .
RUN npm run build

# Production stage
FROM nginx:stable-alpine AS production
COPY --from=build /app/dist /usr/share/nginx/html
COPY default.conf /etc/nginx/conf.d/default.conf
EXPOSE 3002
CMD ["nginx", "-g", "daemon off;"]