FROM node:18.17.1

WORKDIR /app

ENV PATH /app/node_modules/.bin:$PATH

COPY gamerpay-test-frontend/package*.json ./

RUN yarn install

COPY . .

EXPOSE 5000

CMD ["yarn", "dev", "--host", "0.0.0.0"]