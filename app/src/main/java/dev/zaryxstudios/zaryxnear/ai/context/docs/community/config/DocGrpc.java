package dev.zaryxstudios.zaryxnear.ai.context.docs.community.config;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.66.0)",
    comments = "Source: community_doc.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DocGrpc {

  private DocGrpc() {}

  public static final java.lang.String SERVICE_NAME = "zaryxnear.docs.community.Doc";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.DocRequestProto,
      dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.DocResponseProto> getGetDocInformationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDocInformation",
      requestType = dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.DocRequestProto.class,
      responseType = dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.DocResponseProto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.DocRequestProto,
      dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.DocResponseProto> getGetDocInformationMethod() {
    io.grpc.MethodDescriptor<dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.DocRequestProto, dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.DocResponseProto> getGetDocInformationMethod;
    if ((getGetDocInformationMethod = DocGrpc.getGetDocInformationMethod) == null) {
      synchronized (DocGrpc.class) {
        if ((getGetDocInformationMethod = DocGrpc.getGetDocInformationMethod) == null) {
          DocGrpc.getGetDocInformationMethod = getGetDocInformationMethod =
              io.grpc.MethodDescriptor.<dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.DocRequestProto, dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.DocResponseProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDocInformation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.DocRequestProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.DocResponseProto.getDefaultInstance()))
              .setSchemaDescriptor(new DocMethodDescriptorSupplier("GetDocInformation"))
              .build();
        }
      }
    }
    return getGetDocInformationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.EmptyRequest,
      dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.CategoryTreeResponse> getGetCategoryTreeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCategoryTree",
      requestType = dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.EmptyRequest.class,
      responseType = dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.CategoryTreeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.EmptyRequest,
      dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.CategoryTreeResponse> getGetCategoryTreeMethod() {
    io.grpc.MethodDescriptor<dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.EmptyRequest, dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.CategoryTreeResponse> getGetCategoryTreeMethod;
    if ((getGetCategoryTreeMethod = DocGrpc.getGetCategoryTreeMethod) == null) {
      synchronized (DocGrpc.class) {
        if ((getGetCategoryTreeMethod = DocGrpc.getGetCategoryTreeMethod) == null) {
          DocGrpc.getGetCategoryTreeMethod = getGetCategoryTreeMethod =
              io.grpc.MethodDescriptor.<dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.EmptyRequest, dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.CategoryTreeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCategoryTree"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.EmptyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.CategoryTreeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DocMethodDescriptorSupplier("GetCategoryTree"))
              .build();
        }
      }
    }
    return getGetCategoryTreeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DocStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DocStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DocStub>() {
        @java.lang.Override
        public DocStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DocStub(channel, callOptions);
        }
      };
    return DocStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DocBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DocBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DocBlockingStub>() {
        @java.lang.Override
        public DocBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DocBlockingStub(channel, callOptions);
        }
      };
    return DocBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DocFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DocFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DocFutureStub>() {
        @java.lang.Override
        public DocFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DocFutureStub(channel, callOptions);
        }
      };
    return DocFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getDocInformation(dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.DocRequestProto request,
        io.grpc.stub.StreamObserver<dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.DocResponseProto> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDocInformationMethod(), responseObserver);
    }

    /**
     */
    default void getCategoryTree(dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.EmptyRequest request,
        io.grpc.stub.StreamObserver<dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.CategoryTreeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCategoryTreeMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Doc.
   */
  public static abstract class DocImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return DocGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Doc.
   */
  public static final class DocStub
      extends io.grpc.stub.AbstractAsyncStub<DocStub> {
    private DocStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DocStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DocStub(channel, callOptions);
    }

    /**
     */
    public void getDocInformation(dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.DocRequestProto request,
        io.grpc.stub.StreamObserver<dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.DocResponseProto> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDocInformationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCategoryTree(dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.EmptyRequest request,
        io.grpc.stub.StreamObserver<dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.CategoryTreeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCategoryTreeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Doc.
   */
  public static final class DocBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DocBlockingStub> {
    private DocBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DocBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DocBlockingStub(channel, callOptions);
    }

    /**
     */
    public dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.DocResponseProto getDocInformation(dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.DocRequestProto request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDocInformationMethod(), getCallOptions(), request);
    }

    /**
     */
    public dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.CategoryTreeResponse getCategoryTree(dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.EmptyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCategoryTreeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Doc.
   */
  public static final class DocFutureStub
      extends io.grpc.stub.AbstractFutureStub<DocFutureStub> {
    private DocFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DocFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DocFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.DocResponseProto> getDocInformation(
        dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.DocRequestProto request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDocInformationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.CategoryTreeResponse> getCategoryTree(
        dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.EmptyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCategoryTreeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_DOC_INFORMATION = 0;
  private static final int METHODID_GET_CATEGORY_TREE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_DOC_INFORMATION:
          serviceImpl.getDocInformation((dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.DocRequestProto) request,
              (io.grpc.stub.StreamObserver<dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.DocResponseProto>) responseObserver);
          break;
        case METHODID_GET_CATEGORY_TREE:
          serviceImpl.getCategoryTree((dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.EmptyRequest) request,
              (io.grpc.stub.StreamObserver<dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.CategoryTreeResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetDocInformationMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.DocRequestProto,
              dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.DocResponseProto>(
                service, METHODID_GET_DOC_INFORMATION)))
        .addMethod(
          getGetCategoryTreeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.EmptyRequest,
              dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.CategoryTreeResponse>(
                service, METHODID_GET_CATEGORY_TREE)))
        .build();
  }

  private static abstract class DocBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DocBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.DocProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Doc");
    }
  }

  private static final class DocFileDescriptorSupplier
      extends DocBaseDescriptorSupplier {
    DocFileDescriptorSupplier() {}
  }

  private static final class DocMethodDescriptorSupplier
      extends DocBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DocMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (DocGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DocFileDescriptorSupplier())
              .addMethod(getGetDocInformationMethod())
              .addMethod(getGetCategoryTreeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
